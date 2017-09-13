angular.module('gravadoraServicos', ['ngResource'])
	.factory('recursoGravadora', function($resource) {

		return $resource('/v1/gravadoras/:gravadoraId', null, {
			'update' : { 
				method: 'PUT'
			}
		});
	})
	.factory("cadastroDeGravadoras", function(recursoGravadora, $q, $rootScope) {
		
		var evento = 'gravadoraCadastrada';

		var service = {};

		service.cadastrar = function(gravadora) {
			return $q(function(resolve, reject) {

				if(gravadora._id) {
					recursoGravadora.update({gravadoraId: gravadora._id}, gravadora, function() {

						$rootScope.$broadcast(evento);
						resolve({
							mensagem: 'Gravadora ' + gravadora.nome + ' atualizada com sucesso',
							inclusao: false
						});
					}, function(erro) {
						console.log(erro);
						reject({
							mensagem: 'Não foi possível atualizar a gravadora ' + gravadora.nome
						});
					});

				} else {
					recursoGravadora.save(gravadora, function() {
						$rootScope.$broadcast(evento);
						resolve({
							mensagem: 'Gravadora ' + gravadora.nome + ' incluída com sucesso',
							inclusao: true
						});
					}, function(erro) {
						console.log(erro);
						reject({
							mensagem: 'Não foi possível incluir a gravadora ' + gravadora.titulo
						});
					});
				}
			});
		};
		return service;
    });