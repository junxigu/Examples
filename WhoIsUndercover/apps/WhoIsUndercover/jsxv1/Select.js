/** @jsx React.DOM */
'use strict';
define(['react', ], 
        function( React ){
  
  var ReactPropTypes = React.PropTypes;
  
  var Select = React.createClass({

    propTypes: {
      count: ReactPropTypes.number.isRequired,
      title: ReactPropTypes.string.isRequired,
      opt: ReactPropTypes.number.isRequired,
    },
    
    getDefaultProps : function(){
      return {
        min: 1,
      };
    },
    
    render: function() {
      var props = this.props,
        count = props.count,
        opt = props.opt || props.min,
        options = [], select = [];
      
      for(var i = props.min; i <= count; i++){
        options.push(<option key={i} value={i}>{i}</option>);
      }
      
      // Return setting page
      return (
        <div>
          <label>{props.title}</label>
          <select ref='selectRef' value={opt}>{options}</select>
        </div>
      );
    },
    
  });
  
  return Select;
});
  
