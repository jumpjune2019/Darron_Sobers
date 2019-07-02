window.addEventListener("load", init, false);

function init() {

    var playPlay = document.getElementById("playBtn");
    var playStop = document.getElementById("playBtn");
    var page = 0;
    var state = 'startGame';

    var timer = function() {
        var countS = 0;
        var countM = 0;
        var countH = 0;
        page++;
        
        console.log("I have started timing");
        var setIntervalFunc = function() {
            var clockStart = document.getElementById("refreshmytime");
            var countSec = countS < 10 ? "0" + countS++ : countS++;
            var countMin = countM < 10 ? "0" + countM: countM;
            var countHour = countH < 10 ? "0" + countH: countH;
            if (countSec == 59) {
                countS = -1;
                countM++;
            } else if (countMin == 59) {
                countM = 0;
                countH++;
            }
            
            clockStart.innerHTML = countHour + ":" + countMin + ":" + countSec;
        }
        
        setInterval(setIntervalFunc, 1000);
        var ss = setInterval(setIntervalFunc, 1000);
        
        var stopBtnClick = function() {
            clearInterval(ss);
        }

        if(page == 2) {
            playStop.addEventListener("click", stopBtnClick, false);

        }

        if (page == 3) {
            page = 0;
        }
        if (state == 'startGame') {
            state = 'stopGame';
            playPlay.innerHTML = "End";
        }
    }
        playPlay.addEventListener("click", timer, false);
        
        
        var addContent = function() {

            if (page == 1) {
                
                var colOne = document.createElement("div");
                gameArea.appendChild(colOne);
                colOne.id = "firstCol";

                var colTwo = document.createElement("div");
                gameArea.appendChild(colTwo);
                colTwo.id = "secCol";

                var newfield1 = document.createElement("div");
                colOne.appendChild(newfield1);
                newfield1.id = "child1"; 
                newfield1.className = "childCol1";
                newfield1.innerHTML= "<h2>I am child 1</h2>";
                newfield1.draggable = "true";
                
                var newfield2 = document.createElement("div");
                colOne.appendChild(newfield2);
                newfield2.id = "child2"; 
                newfield2.className = "childCol1";
                newfield2.innerHTML= "<h2>I am child 2</h2>";
                
                var newfield3 = document.createElement("div");
                colOne.appendChild(newfield3);
                newfield3.id = "child3"; 
                newfield3.className = "childCol1";
                newfield3.innerHTML= "<h2>I am child 3</h2>";

                var newfield4 = document.createElement("div");
                colOne.appendChild(newfield4);
                newfield4.id = "child4"; 
                newfield4.className = "childCol1";
                newfield4.innerHTML= "<h2>I am child 4</h2>";

                var newfield5 = document.createElement("div");
                colOne.appendChild(newfield5);
                newfield5.id = "child5"; 
                newfield5.className = "childCol1";
                newfield5.innerHTML= "<h2>I am child 5</h2>";
                
                
                var defCol1 = document.createElement("div");
                colTwo.appendChild(defCol1);
                defCol1.id = "def1";
                defCol1.className = "defColumn";
                var defDrop = document.createElement("div");
                defCol1.appendChild(defDrop);
                defDrop.id = "defDrop1";
                defDrop.className = "defDrop";
                var defValue = document.createElement("div");
                defCol1.appendChild(defValue);
                defValue.className = "defVal";
                
                var defCol2 = document.createElement("div");
                colTwo.appendChild(defCol2);
                defCol2.id = "def2";
                defCol2.className = "defColumn";
                var defDrop2 = document.createElement("div");
                defCol2.appendChild(defDrop2);
                defDrop2.id = "defDrop2";
                defDrop2.className = "defDrop";
                var defValue2 = document.createElement("div");
                defCol2.appendChild(defValue2);
                defValue2.className = "defVal";

                
                var defCol3 = document.createElement("div");
                colTwo.appendChild(defCol3);
                defCol3.id = "def3";
                defCol3.className = "defColumn";
                var defDrop3 = document.createElement("div");
                defCol3.appendChild(defDrop3);
                defDrop3.id = "defDrop3";
                defDrop3.className = "defDrop";
                var defValue3 = document.createElement("div");
                defCol3.appendChild(defValue3);
                defValue3.className = "defVal";
                
                var defCol4 = document.createElement("div");
                colTwo.appendChild(defCol4);
                defCol4.id = "def4";
                defCol4.className = "defColumn";
                var defDrop4 = document.createElement("div");
                defCol4.appendChild(defDrop4);
                defDrop4.id = "defDrop4";
                defDrop4.className = "defDrop";
                var defValue4 = document.createElement("div");
                defCol4.appendChild(defValue4);
                defValue4.className = "defVal";
                
                var defCol5 = document.createElement("div");
                colTwo.appendChild(defCol5);
                defCol5.id = "def5";
                defCol5.className = "defColumn";
                var defDrop5 = document.createElement("div");
                defCol5.appendChild(defDrop5);
                defDrop5.id = "defDrop5";
                defDrop5.className = "defDrop";
                var defValue5 = document.createElement("div");
                defCol5.appendChild(defValue5);
                defValue5.className = "defVal";
                
                
                var dragItem = document.getElementById("child1");
                var dropArea = document.getElementById("defDrop1");
                
                function startDragItemFunc(e) {
                    e.dataTransfer.setData("text", e.target.id);
                    console.log("Starting Drag");
                }
                
                function dropItemFunc(e) {
                    e.preventDefault();
                    var data = e.dataTransfer.getData("text");
                    var dragEl = document.getElementById(data)
                    e.target.innerHTML = dragEl.innerHTML;
                    dragEl.innerHTML = "";
                }
                
                function dragOverItemFunc(e) {
                    e.preventDefault();
                    console.log("Starting Drag");
                }
                
                dragItem.addEventListener("dragstart", startDragItemFunc, false);
                dropArea.addEventListener("drop", dropItemFunc, false);
                dropArea.addEventListener("dragover", dragOverItemFunc, false);
                
            }
            
        }
        playPlay.addEventListener("click", addContent, false);
        
    }

    //playPlay.addEventListener("click", timer, false);