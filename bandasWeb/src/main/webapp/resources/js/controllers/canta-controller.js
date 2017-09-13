angular.module('BandaApp')
	.controller('CantaController', ['$scope', 'recursoCanta', '$routeParams', 'cadastroDeCantas', function($scope, recursoCanta, $routeParams, cadastroDeCantas) {

		$scope.canta = {};
		$scope.mensagem = '';

		if($routeParams.cantaId) {
			recursoCanta.get({cantaId: $routeParams.cantaId}, function(canta) {
				$scope.canta = canta; 
			}, function(erro) {
				console.log(erro);
				$scope.mensagem = 'Não foi possível obter a Canta'
			});
		}

		$scope.submeter = function() {

			if ($scope.formulario.$valid) {
				cadastroDeCantas.cadastrar($scope.canta)
				.then(function(dados) {
					$scope.mensagem = dados.mensagem;
					if (dados.inclusao) $scope.canta = {};
				})
				.catch(function(erro) {
					$scope.mensagem = erro.mensagem;
				});
			}
		};
	}]);