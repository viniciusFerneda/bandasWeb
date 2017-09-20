angular.module('BandaApp')
	.controller('PaisController', ['$scope', 'recursoPais', '$routeParams', 'cadastroDePaises', function($scope, recursoPais, $routeParams, cadastroDePaises) {

		$scope.pais = {};
		$scope.mensagem = '';

		if($routeParams.paisId) {
			recursoPais.get({paisId: $routeParams.paisId}, function(pais) {
				$scope.pais = pais; 
			}, function(erro) {
				console.log(erro);
				$scope.mensagem = 'Não foi possível obter a Banda'
			});
		}

		$scope.submeter = function() {
			if ($scope.formulario.$valid) {
				cadastroDePaises.cadastrar($scope.pais)
				.then(function(dados) {
					$scope.mensagem = dados.mensagem;
					if (dados.inclusao) $scope.pais = {};
				})
				.catch(function(erro) {
					$scope.mensagem = erro.mensagem;
				});
			}
		};
	}]);