angular.module('cantaServicos', ['ngResource'])
	.factory('recursoCanta', function($resource) {

		return $resource('/bandasWeb/rest/cantas/:cantaId', null, {
			'update' : { 
				method: 'PUT'
			}
		});
	})
	.factory("cadastroDeCantas", function(recursoCanta, $q, $rootScope) {
		
		var evento = 'cantaCadastrada';

		var service = {};

		service.cadastrar = function(canta) {
			return $q(function(resolve, reject) {
				if(canta.codigo) {
					recursoCanta.update(canta, function() {
						$rootScope.$broadcast(evento);
						resolve({
							mensagem: 'Canta ' + canta.musica + ' atualizada com sucesso',
							inclusao: false
						});
					}, function(erro) {
						console.log(erro);
						reject({
							mensagem: 'Não foi possível atualizar a canta ' + canta.musica
						});
					});
				} else {
					recursoCanta.save(canta, function() {
						$rootScope.$broadcast(evento);
						resolve({
							mensagem: 'Canta ' + canta.musica + ' incluída com sucesso',
							inclusao: true
						});
					}, function(erro) {
						console.log(erro);
						reject({
							mensagem: 'Não foi possível incluir a canta ' + canta.musica
						});
					});
				}
			});
		};
		return service;
    });