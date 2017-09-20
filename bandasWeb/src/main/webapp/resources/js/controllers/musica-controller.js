angular.module('BandaApp')
	.controller('MusicaController', ['$scope', 'recursoMusica', '$routeParams', 'cadastroDeMusicas', function($scope, recursoMusica, $routeParams, cadastroDeMusicas) {

		$scope.musica = {};
		$scope.mensagem = '';

		if($routeParams.musicaId) {
			recursoMusica.get({musicaId: $routeParams.musicaId}, function(musica) {
				$scope.musica = musica; 
			}, function(erro) {
				console.log(erro);
				$scope.mensagem = 'Não foi possível obter a Banda'
			});
		}

		$scope.submeter = function() {

			if ($scope.formulario.$valid) {
				cadastroDeMusicas.cadastrar($scope.musica)
				.then(function(dados) {
					$scope.mensagem = dados.mensagem;
					if (dados.inclusao) $scope.musica = {};
				})
				.catch(function(erro) {
					$scope.mensagem = erro.mensagem;
				});
			}
		};
	}]);