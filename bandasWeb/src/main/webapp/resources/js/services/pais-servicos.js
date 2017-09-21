angular.module('paisServicos', ['ngResource'])
	.factory('recursoPais', function($resource) {
		return $resource('/bandasWeb/rest/paises/:paisId', null, {
			'update' : { 
				method: 'PUT'
			}
		});
	})
	.factory("cadastroDePaises", function(recursoPais, $q, $rootScope) {
		
		var evento = 'paisCadastrado';

		var service = {};

		service.cadastrar = function(pais) {
			return $q(function(resolve, reject) {
				if(pais.codigo) {
					recursoPais.update(pais, function() {
						$rootScope.$broadcast(evento);
						resolve({
							mensagem: 'País ' + pais.nome + ' atualizado com sucesso',
							inclusao: false
						});
					}, function(erro) {
						console.log(erro);
						reject({
							mensagem: 'Não foi possível atualizar o País ' + pais.nome
						});
					});
				} else {
					recursoPais.save(pais, function() {
						$rootScope.$broadcast(evento);
						resolve({
							mensagem: 'Pais ' + pais.nome + ' incluído com sucesso',
							inclusao: true
						});
					}, function(erro) {
						console.log(erro);
						reject({
							mensagem: 'Não foi possível incluir a pais ' + pais.titulo
						});
					});
				}
			});
		};
		return service;
    });