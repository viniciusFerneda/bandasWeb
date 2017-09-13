angular.module('musicaServicos', ['ngResource'])
	.factory('recursoMusica', function($resource) {

		return $resource('/v1/musicas/:musicaId', null, {
			'update' : { 
				method: 'PUT'
			}
		});
	})
	.factory("cadastroDeMusicas", function(recursoMusica, $q, $rootScope) {
		
		var evento = 'musicaCadastrada';

		var service = {};

		service.cadastrar = function(musica) {
			return $q(function(resolve, reject) {

				if(musica._id) {
					recursoMusica.update({musicaId: musica._id}, musica, function() {

						$rootScope.$broadcast(evento);
						resolve({
							mensagem: 'Musica ' + musica.nome + ' atualizada com sucesso',
							inclusao: false
						});
					}, function(erro) {
						console.log(erro);
						reject({
							mensagem: 'Não foi possível atualizar a musica ' + musica.nome
						});
					});

				} else {
					recursoMusica.save(musica, function() {
						$rootScope.$broadcast(evento);
						resolve({
							mensagem: 'Musica ' + musica.nome + ' incluída com sucesso',
							inclusao: true
						});
					}, function(erro) {
						console.log(erro);
						reject({
							Bensagem: 'Não foi possível incluir a musica ' + musica.titulo
						});
					});
				}
			});
		};
		return service;
    });