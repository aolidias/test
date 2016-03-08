'use strict';

App.factory('ContactService', ['$http', '$q', function($http, $q){

	return {
		
			fetchAllContacts: function() {
					return $http.get('http://localhost:8080/fiveware/api/v1/contact/')
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while fetching contacts');
										return $q.reject(errResponse);
									}
							);
			},
		    
		    createContact: function(contact){
					return $http.post('http://localhost:8080/fiveware/api/v1/contact/', contact)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while creating contact');
										return $q.reject(errResponse);
									}
							);
		    },
		    
		    updateContact: function(contact, id){
					return $http.put('http://localhost:8080/fiveware/api/v1/contact/'+id, contact)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while updating contact');
										return $q.reject(errResponse);
									}
							);
			},
		    
			deleteContact: function(contact){
					return $http.delete('http://localhost:8080/fiveware/api/v1/contact/'+contact)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while deleting contact');
										return $q.reject(errResponse);
									}
							);
			}
		
	};

}]);
