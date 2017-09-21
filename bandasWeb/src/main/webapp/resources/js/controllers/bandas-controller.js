angular.module("BandaApp").controller("BandasController",function($scope, recursoBanda) {

	$scope.bandas = [];
	$scope.filtro = '';
	$scope.mensagem = '';

	recursoBanda.query(function(bandas) {
		$scope.bandas = bandas;
	}, function(erro) {
		console.log(erro);
	});

	$scope.remover = function(banda) {
		recursoBanda.delete({bandaId: banda.codigo}, function() {
			var indiceDaBanda = $scope.bandas.indexOf(banda);
			$scope.bandas.splice(indiceDaBanda, 1);
			$scope.mensagem = 'Banda ' + banda.nome + ' removida com sucesso!';
		}, function(erro) {
			console.log(erro);
			$scope.mensagem = 'Não foi possível apagar a banda ' + banda.tinometulo;
		});
	};
	
});