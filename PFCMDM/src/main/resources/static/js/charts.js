/**
 * 
 */

     var dataModel = /*[[${chartData}]]*/;
    $(document).ready(function() {
        google.charts.load('current', {packages : [ 'corechart' ]});
        google.charts.setOnLoadCallback(drawBarChart);
        google.charts.setOnLoadCallback(drawPieChart);
        window.onload = resize;
        window.onresize = resize;
    });
        function resize () {
        	google.charts.setOnLoadCallback(drawBarChart);
            google.charts.setOnLoadCallback(drawPieChart);
        }

        
    
    
    function drawBarChart() {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Brands');
        data.addColumn('number', 'Products');
        Object.keys(dataModel).forEach(function(key) {
            data.addRow([ key, dataModel[key] ]);
        });
        var options = {
           	pieHole: 0.4,
           	legend: {position: 'top'},
            colors: ['#3366cc', '#dc3912', '#ff9900', '#109618', '#990099', '#ff6600', '#0099c6', '#dd4477', '#66aa00', '#b82e2e']
        };
        var chart = new google.visualization.ColumnChart(document.getElementById('donutchart'));
        chart.draw(data, options);
    }
    
    
    function drawPieChart() {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Brands');
        data.addColumn('number', 'Products');
        Object.keys(dataModel).forEach(function(key) {
            data.addRow([ key, dataModel[key] ]);
        });
        var options = {
            title : 'Nº of products by Brand',
           	pieHole: 0.4,
            colors: ['#3366cc', '#dc3912', '#ff9900', '#109618', '#990099', '#ff6600', '#0099c6', '#dd4477', '#66aa00', '#b82e2e']
        };
        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
        chart.draw(data, options);
    }