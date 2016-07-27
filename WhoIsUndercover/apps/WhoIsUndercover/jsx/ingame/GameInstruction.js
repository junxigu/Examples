/** @jsx React.DOM */
'use strict';
define(['react', 'action/Actions', ], 
        function( React, Actions){
  
  var localize = Globalize.localize.bind(Globalize);
  
  var GameInstruction = React.createClass({

    render: function() {
      return (
        <li data-role="list-divider">
          <span className="instruction">查看词语</span>
          <span className="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
          <span className="instruction second">杀死玩家</span>
          <span className="glyphicon glyphicon-remove" aria-hidden="true"></span>
        </li>
      );
    },
    
  });
  
  return GameInstruction;
});
  
