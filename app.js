var GPIO = require('onoff').Gpio,
    //led = new GPIO(18, 'out'),
    button = new GPIO(4, 'in', 'both'),
    date = new Date();
    var theDate = date.getDate() + "/" + date.getMonth() + "/" + date.getFullYe$

// define the callback function
function light(err, state) {

  // check the state of the button
  // 1 == pressed, 0 == not pressed
  if(state == 1) {
    // turn LED on
    //led.writeSync(1);
console.log(theDate);
} else {
    // turn LED off
    //led.writeSync(0);
console.log(theDate);
  }

}

// pass the callback function to the
// as the first argument to watch()
button.watch(light);