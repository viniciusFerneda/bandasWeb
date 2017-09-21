angular.module('bandaServicos', ['ngResource'])
	.factory('recursoBanda', function($resource) {

		return $resource('/bandasWeb/rest/bandas/:bandaId', null, {
			'update' : { 
				method: 'PUT'
			}
		});
	})
	.factory("cadastroDeBandas", function(recursoBanda, $q, $rootScope) {
		
		var evento = 'bandaCadastrada';

		var service = {};

		service.cadastrar = function(banda) {
			return $q(function(resolve, reject) {
				if(banda.codigo) {
					recursoBanda.update(banda, function() {
						$rootScope.$broadcast(evento);
						resolve({
							mensagem: 'Banda ' + banda.nome + ' atualizada com sucesso',
							inclusao: false
						});
					}, function(erro) {
						console.log(erro);
						reject({
							mensagem: 'Não foi possível atualizar a banda ' + banda.nome
						});
					});
				} else {
					recursoBanda.save(banda, function() {
						$rootScope.$broadcast(evento);
						resolve({
							mensagem: 'Banda ' + banda.nome + ' incluída com sucesso',
							inclusao: true
						});
					}, function(erro) {
						console.log(erro);
						reject({
							mensagem: 'Não foi possível incluir a banda ' + banda.titulo
						});
					});
				}
			});
		};
		return service;
    });