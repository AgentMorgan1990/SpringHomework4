angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app/api/v1';

    $scope.loadProducts = function (pageIndex = 1) {
        $http({
            url: contextPath + '/products',
            method: 'GET',
            params: {
                title_part: $scope.filter ? $scope.filter.title_part : null,
                min_price: $scope.filter ? $scope.filter.min_price : null,
                max_price: $scope.filter ? $scope.filter.max_price : null
            }
        }).then(function (response) {
            $scope.ProductsPage = response.data;
        });
    };


    $scope.changeCount = function (id, count) {
        $http({
            url: contextPath + "/cards",
            method: 'PUT',
            params: {
                id: id,
                count: count
            }
        }).then(function (response) {
            $scope.loadCard();
            // $scope.cardInfo = response.data;
        });
    }
    $scope.addProductToCard = function (id) {
        $http({
            url: contextPath + "/cards",
            method: 'POST',
            params: {
                id: id
            }
        }).then(function (response) {
            // $scope.cardInfo = response.data;
            $scope.loadCard();
        });
    }
    $scope.loadCard = function () {
        $http.get(contextPath + '/cards')
            .then(function (response) {
                $scope.CardList = response.data;
            });
    };
    $scope.deleteFromCard = function (id) {
        $http.delete(contextPath + '/cards/' + id)
            .then(function (response) {
                $scope.loadCard();
            });
    }

    $scope.loadProducts();
    $scope.loadCard();
});