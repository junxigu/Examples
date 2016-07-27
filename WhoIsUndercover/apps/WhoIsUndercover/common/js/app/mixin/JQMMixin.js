define(['jquerymobile'], {
  
  componentDidMount : function() {
    $(this.getDOMNode()).show();
    $('body').enhanceWithin();
  },

});
