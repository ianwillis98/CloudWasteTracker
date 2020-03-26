/**
 * 
 */
var Table = document.getElementById("collection");
var wholeTable = Table.getElementsByTagName("tr");
var tempObj = [];
var x =[];
var y = [];
for (i=0; i<wholeTable.length;i++){
	tempObj[i] ={ID:"", Totalspend:""} 
	
	tempObj[i].ID= wholeTable[i].cells[1].innerText;
	x[i]= tempObj[i].ID
	tempObj[i].Totalspend = parseFloat(wholeTable[i].cells[6].innerText.replace(/[^\d\.-]/g,""));
	y[i]= tempObj[i].Totalspend;
} 
console.log(x[161]);
const ctx = document.getElementById('chart').getContext('2d');
const xlabels = x;
const myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: xlabels,
        datasets: [{
            label: 'ID versus TotalSpend',
            data: y,
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true
                }
            }]
        }
    }
});



