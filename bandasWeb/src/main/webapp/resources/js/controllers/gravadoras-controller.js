angular.module("BandaApp").controller("GravadorasController",function($scope, recursoGravadora) {

	$scope.gravadoras = [];
	$scope.filtro = '';
	$scope.mensagem = '';

	recursoGravadora.query(function(gravadoras) {
		$scope.gravadoras = gravadoras;
	}, function(erro) {
		console.log(erro);
	});

	$scope.remover = function(gravadora) {
		recursoGravadora.delete({gravadoraId: gravadora.codigo}, function() {
			var indiceDaGravadora = $scope.gravadoras.indexOf(gravadora);
			$scope.gravadoras.splice(indiceDaGravadora, 1);
			$scope.mensagem = 'Gravadora ' + gravadora.nome + ' removida com sucesso!';
		}, function(erro) {
			console.log(erro);
			$scope.mensagem = 'Não foi possível apagar a gravadora ' + gravadora.nome;
		});
	};
	
});