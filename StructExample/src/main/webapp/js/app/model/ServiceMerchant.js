define([ 'backbone', 'util/AjaxUtils', ], function(Backbone, AjaxUtils) {

  return Backbone.Model.extend({

    defaults : {
      id : 0,
      serviceMerchantId : 0,
      countryCode : 0,
      alias : '',
      password : '',
      partnerId : '',
      systemId : '',
      certificate : '',
      description : '',
      creationTime : '',
      updateTime : '',
    },

  });

});