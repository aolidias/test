<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>Fiveware Test</title>  
    <style>
      .firstName.ng-valid {
          background-color: lightgreen;
      }
      .firstName.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .firstName.ng-dirty.ng-invalid-minlength {
          background-color: yellow;
      }

    </style>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
  </head>
  <body ng-app="myApp" class="ng-cloak">
      <div class="generic-container" ng-controller="ContactController as ctrl">
          <div class="panel panel-default">
          
              <div class="panel-heading-per"><span class="lead">Contact Register </span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.contact.id" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="firstName">First Name</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.contact.firstName" name="firstName" class="firstName form-control input-sm" placeholder="Enter your first name" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.firstName.$error.required">This is a required field</span>
                                      <span ng-show="myForm.firstName.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.firstName.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
						<div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="lastName">Last Name</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.contact.lastName" name="lastName" class="firstName form-control input-sm" placeholder="Enter your last name" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.lastName.$error.required">This is a required field</span>
                                      <span ng-show="myForm.lastName.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.lastName.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="sex">Sex</label>
                              <div class="col-md-7">
                               <label><input type="radio" ng-model="ctrl.contact.sex" value="Female" ng-required="!ctrl.contact.sex">Female</label><br/>
                               <label><input type="radio" ng-model="ctrl.contact.sex" value="Male" ng-required="!ctrl.contact.sex">Male</label>
                               <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.sex.$error.required">This is a required field</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="single">Is Single?</label>
                              <div class="col-md-7">
                              <input type="checkbox" ng-model="ctrl.contact.single">
                               <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.single.$error.required">This is a required field</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="month">Favorite Month</label>
                              <div class="col-md-7">
                              <select name="month" ng-model="ctrl.contact.favoriteMonth" ng-options="opt as opt for opt in months" ng-init="selected='May'" required></select>
                              <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.favoriteMonth.$error.required">This is a required field</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                         

                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.contact.id ? 'Save' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
              <div class="panel-heading-per"><span class="lead">List of Contacts </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID</th>
                              <th>First Name</th>
                              <th>Last Name</th>
                              <th>Sex</th>
                              <th>Is Single?</th>
                              <th>Favorite Month</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="c in ctrl.contacts">
                              <td><span ng-bind="c.id"></span></td>
                              <td><span ng-bind="c.firstName"></span></td>
                              <td><span ng-bind="c.lastName"></span></td>
                              <td><span ng-bind="c.sex"></span></td>
                              <td><span ng-bind="c.single"></span></td>
                              <td><span ng-bind="c.favoriteMonth"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(c.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(c.id)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
      
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="<c:url value='/static/js/app.js' />"></script>
      <script src="<c:url value='/static/js/service/contact_service.js' />"></script>
      <script src="<c:url value='/static/js/controller/contact_controller.js' />"></script>
  </body>
</html>