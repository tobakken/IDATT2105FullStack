<template>
  <div class="input">
    <p>{{calculatorValue}}</p>
  </div>
  <div>
    <button v-for="n in calculatorNmb" :key="n"
            @click="add(n)" >{{n}}</button>
  </div>
  <button v-for="n in calculatorEvents" :key="n"
          @click="event(n)"> {{n}}</button>
  <div v-for="ev in calculatorLog" :key="ev"> {{ev}}</div>
</template>

<script>
export default {
  name: "Calculator",
  data() {
    return {
      calculatorValue: '',
      prevCalcValue: '',
      operator: null,
      calculatorNmb: [
          '1',
          '2',
          '3',
          '4',
          '5',
          '6',
          '7',
          '8',
          '9',
          '0'
      ],
      calculatorEvents: [
          '+',
          '-',
          '*',
          '/',
          '=',
          'AC'
      ],
      calculatorLog: []
    }
  },

  methods: {
    add(n){
      this.calculatorValue += n
    },
    event(n) {
     if (n === 'AC'){
       this.calculatorValue = ''
     }
     if (['/', '+', '-', '*'].includes(n)) {
       this.operator = n;
       this.prevCalcValue = this.calculatorValue;
       this.calculatorValue = ''
     }
      if (n === '=') {
        var result = this.prevCalcValue + this.operator + this.calculatorValue;
        this.calculatorValue = eval(result);
        this.calculatorLog.push(result + '=' + this.calculatorValue);
        this.operator = null
     }
    }
  }
}
</script>

<style scoped>
.input{
  border-style: solid;
  width: 50%;
  margin: auto;
}
</style>