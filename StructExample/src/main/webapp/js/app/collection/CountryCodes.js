define([ 'backbone', 'model/CountryCode', 'util/AjaxUtils', ],
  function(Backbone, CountryCode, AjaxUtils) {

    var CountryCodes =  Backbone.Collection.extend({

      model : CountryCode,

    }, {

      getCountryCodes : function(handleCollection) {
        var fetchUrl = '/speedpasselement/serviceMerchantTokens/countryCodes';
        $.post(fetchUrl, AjaxUtils.getCommonRequestHandler(function(jsonData){
          handleCollection && handleCollection(new CountryCodes(jsonData));
        }));
      },
    });
    
    return CountryCodes;
  });