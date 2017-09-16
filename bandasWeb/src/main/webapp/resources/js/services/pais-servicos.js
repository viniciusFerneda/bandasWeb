angular.module('paisServicos', ['ngResource'])
	.factory('recursoPais', function($resource) {
		return $resource('/bandasWeb/paises/:paisId', {}, {
		    query: {
		      method: 'GET',
		      transformResponse: function(data) {
		        return angular.fromJson(data).events;
		      },
		      isArray: true
		    }
		  });
		return $resource('/bandasWeb/paises/:paisId', null, {
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

				if(pais._id) {
					recursoPais.update({paisId: pais._id}, pais, function() {

						$rootScope.$broadcast(evento);
						resolve({
							mensagem: 'Pais ' + pais.nome + ' atualizada com sucesso',
							inclusao: false
						});
					}, function(erro) {
						console.log(erro);
						reject({
							mensagem: 'Não foi possível atualizar a pais ' + pais.nome
						});
					});

				} else {
					recursoPais.save(pais, function() {
						$rootScope.$broadcast(evento);
						resolve({
							mensagem: 'Pais ' + pais.nome + ' incluída com sucesso',
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