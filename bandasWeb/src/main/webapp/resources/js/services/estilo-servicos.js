angular.module('estiloServicos', ['ngResource'])
	.factory('recursoEstilo', function($resource) {
		return $resource('/bandasWeb/rest/estilos/:estiloId', null, {
			'update' : { 
				method: 'PUT'
			}
		});
	})
	.factory("cadastroDeEstilos", function(recursoEstilo, $q, $rootScope) {
		
		var evento = 'estiloCadastrada';

		var service = {};

		service.cadastrar = function(estilo) {
			return $q(function(resolve, reject) {
				if(estilo.codigo) {
					recursoEstilo.update(estilo, function() {
						$rootScope.$broadcast(evento);
						resolve({
							mensagem: 'Estilo ' + estilo.nome + ' atualizada com sucesso',
							inclusao: false
						});
					}, function(erro) {
						console.log(erro);
						reject({
							mensagem: 'Não foi possível atualizar a estilo ' + estilo.nome
						});
					});

				} else {
					recursoEstilo.save(estilo, function() {
						$rootScope.$broadcast(evento);
						resolve({
							mensagem: 'Estilo ' + estilo.nome + ' incluída com sucesso',
							inclusao: true
						});
					}, function(erro) {
						console.log(erro);
						reject({
							mensagem: 'Não foi possível incluir a estilo ' + estilo.titulo
						});
					});
				}
			});
		};
		return service;
    });