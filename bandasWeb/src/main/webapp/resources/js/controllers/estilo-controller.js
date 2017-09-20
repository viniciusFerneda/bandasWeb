angular.module('BandaApp')
	.controller('EstiloController', ['$scope', 'recursoEstilo', '$routeParams', 'cadastroDeEstilos', function($scope, recursoEstilo, $routeParams, cadastroDeEstilos) {

		$scope.estilo = {};
		$scope.mensagem = '';

		if($routeParams.estiloId) {
			recursoEstilo.get({estiloId: $routeParams.estiloId}, function(estilo) {
				$scope.estilo = estilo; 
			}, function(erro) {
				console.log(erro);
				$scope.mensagem = 'Não foi possível obter a Banda'
			});
		}

		$scope.submeter = function() {

			if ($scope.formulario.$valid) {
				cadastroDeEstilos.cadastrar($scope.estilo)
				.then(function(dados) {
					$scope.mensagem = dados.mensagem;
					if (dados.inclusao) $scope.estilo = {};
				})
				.catch(function(erro) {
					$scope.mensagem = erro.mensagem;
				});
			}
		};
	}]);