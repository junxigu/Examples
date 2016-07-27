define([], function() {

  return {

    appendIdToSelect : function(valTextObj, $select) {
      for(var key in valTextObj){
        $select.append($('<option>').html(valTextObj[key]).attr('value', key));
      }
      return this;
    },

    collectInfoToToken: function($tags, token){
      var $tag, className, i, len;
      for(i = 0, len = $tags.length; i < len; i++){
        $tag = $($tags[i]);
        className = $tag.attr('class');
        className && token.set(className, $tag.val());
      }
      return this;
    },
  };

});