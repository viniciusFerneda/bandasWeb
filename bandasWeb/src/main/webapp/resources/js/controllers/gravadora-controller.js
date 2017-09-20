angular.module('BandaApp')
	.controller('GravadoraController', ['$scope', 'recursoGravadora', '$routeParams', 'cadastroDeGravadoras', function($scope, recursoGravadora, $routeParams, cadastroDeGravadoras) {

		$scope.gravadora = {};
		$scope.mensagem = '';

		if($routeParams.gravadoraId) {
			recursoGravadora.get({gravadoraId: $routeParams.gravadoraId}, function(gravadora) {
				$scope.gravadora = gravadora; 
			}, function(erro) {
				console.log(erro);
				$scope.mensagem = 'Não foi possível obter a Banda'
			});
		}

		$scope.submeter = function() {
			if ($scope.formulario.$valid) {
				cadastroDeGravadoras.cadastrar($scope.gravadora)
				.then(function(dados) {
					$scope.mensagem = dados.mensagem;
					if (dados.inclusao) $scope.gravadora = {};
				})
				.catch(function(erro) {
					$scope.mensagem = erro.mensagem;
				});
			}
		};
	}]);