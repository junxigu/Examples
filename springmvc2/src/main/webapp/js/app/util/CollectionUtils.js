define([], function() {

  return {

    getOptValText: function(coll, valAttr, textAttr){
      return _.object(coll.pluck(valAttr), coll.pluck(textAttr));
    },
    
  };

});