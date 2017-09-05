angular.module('BandaApp')
	.controller('BandaController', ['$scope', 'recursoBanda', '$routeParams', 'cadastroDeBandas', function($scope, recursoBanda, $routeParams, cadastroDeBandas) {

		$scope.banda = {};
		$scope.mensagem = '';

		if($routeParams.bandaId) {
			recursoBanda.get({bandaId: $routeParams.bandaId}, function(banda) {
				$scope.banda = banda; 
			}, function(erro) {
				console.log(erro);
				$scope.mensagem = 'Não foi possível obter a Banda'
			});
		}

		$scope.submeter = function() {

			if ($scope.formulario.$valid) {
				cadastroDeBandas.cadastrar($scope.banda)
				.then(function(dados) {
					$scope.mensagem = dados.mensagem;
					if (dados.inclusao) $scope.banda = {};
				})
				.catch(function(erro) {
					$scope.mensagem = erro.mensagem;
				});
			}
		};
	}]);