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

				if(canta._id) {
					recursoCanta.update({cantaId: canta._id}, canta, function() {

						$rootScope.$broadcast(evento);
						resolve({
							mensagem: 'Canta ' + canta.nome + ' atualizada com sucesso',
							inclusao: false
						});
					}, function(erro) {
						console.log(erro);
						reject({
							mensagem: 'Não foi possível atualizar a canta ' + canta.nome
						});
					});

				} else {
					recursoCanta.save(canta, function() {
						$rootScope.$broadcast(evento);
						resolve({
							mensagem: 'Canta ' + canta.nome + ' incluída com sucesso',
							inclusao: true
						});
					}, function(erro) {
						console.log(erro);
						reject({
							mensagem: 'Não foi possível incluir a canta ' + canta.titulo
						});
					});
				}
			});
		};
		return service;
    });