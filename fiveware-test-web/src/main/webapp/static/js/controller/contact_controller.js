'use strict';

App.controller('ContactController', ['$scope', 'ContactService', function($scope, ContactService) {
			
	      $scope.months = ['January','February','March','April','May','June','July','August','September','October','November','December'];
		  var self = this;
          
          self.contact={id:null,firstName:'',lastName:'', sex:'female', favoriteMonth:''};
          self.contacts=[];
              
          self.fetchAllContacts = function(){
        	  ContactService.fetchAllContacts()
                  .then(
      					       function(d) {
      						        self.contacts = d;
      					       },
            					function(errResponse){
      					    	   window.alert("Error while fetching Contacts");
      					    	   console.error('Error while fetching Contacts');
            					}
      			       );
          };
           
          self.createContact = function(contact){
        	  ContactService.createContact(contact)
		              .then(
                      self.fetchAllContacts, 
				              function(errResponse){
                    	  		window.alert("Duplicate contact.");
					            console.error('Error while creating Contact.');
				              }	
                  );
        	  self.reset();
        	  
          };

         self.updateContact = function(contact, id){
        	 
        	 ContactService.updateContact(contact, id)
		              .then(
				              self.fetchAllContacts, 
				              function() {
	                    	  		window.alert("Contact updated!");
							       },
				              function(errResponse){
				            	  window.alert("Error while updating Contact.");
					              console.error('Error while updating Contact.');
				              }	
                  );
        	 self.reset();
          };

         self.deleteContact = function(id){
        	 ContactService.deleteContact(id)
		              .then(
				              self.fetchAllContacts, 
				              function(errResponse){
				            	  window.alert('Error while deleting Contact.');
					               console.error('Error while deleting Contact.');
				              }	
                  );
          };

          self.fetchAllContacts();

          self.submit = function() {
              if(self.contact.id==null){
                  console.log('Saving New Contact', self.contact);    
                  self.createContact(self.contact);
              }else{
                  self.updateContact(self.contact, self.contact.id);
                  console.log('Contact updated with id ', self.contact.id);
              }
              self.reset();
          };
              
          self.edit = function(id){
              console.log('id to be edited', id);
              for(var i = 0; i < self.contacts.length; i++){
                  if(self.contacts[i].id == id) {
                     self.contact = angular.copy(self.contacts[i]);
                     break;
                  }
              }
          };
              
          self.remove = function(id){
              console.log('id to be deleted', id);
              if(self.contact.id === id) {
                 self.reset();
              }
              self.deleteContact(id);
          };

          
          self.reset = function(){
        	  self.contact={id:null,firstName:'',lastName:'', sex:'female', favoriteMonth:''};
              $scope.myForm.$setPristine(); 
          };

      }]);
