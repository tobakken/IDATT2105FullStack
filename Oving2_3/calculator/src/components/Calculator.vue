<template>
  <div class="calc-body" v-if="this.loginSuccess">
    <div class="input">
      {{ calculatorValue || 0 }}
    </div>
    <div>
      <div class="grid-container">
        <button
          class="btn"
          v-bind:class="{ 'event-btn': calculatorEvents.includes(n) }"
          v-for="n in calculatorBtn"
          :key="n"
          @click="add(n)"
        >
          {{ n }}
        </button>
      </div>
    </div>
  </div>
  <div class="log">
    <p>Previous input:</p>
    <div v-for="ev in calculatorLog" :key="ev">
      {{ ev }}
    </div>
  </div>
</template>

<script>
export default {
  name: "Calculator",
  data() {
    return {
      loginStatus: this.$store.state.status,
      calculatorValue: "",
      prevCalcValue: "",
      operator: null,
      calculatorBtn: [
        "7",
        "8",
        "9",
        "/",
        "4",
        "5",
        "6",
        "*",
        "1",
        "2",
        "3",
        "-",
        "0",
        ".",
        "+",
        "=",
        "AC",
      ],
      calculatorEvents: ["+", "-", "*", "/", "=", "AC"],
      calculatorLog: [],
    };
  },

  methods: {
    add(n) {
      if (this.calculatorEvents.includes(n)) this.event(n);
      else this.calculatorValue += n;
    },
    event(n) {
      if (n === "AC") {
        this.calculatorValue = "";
      }
      if (["/", "+", "-", "*"].includes(n)) {
        if (this.operator === null) {
          this.operator = n;
          this.prevCalcValue = this.calculatorValue;
          this.calculatorValue = "";
        } else this.operator = n;
      }
      if (n === "=") {
        const result =
          this.prevCalcValue + this.operator + this.calculatorValue;
        this.calculatorValue = eval(result);
        this.calculatorLog.push(result + "=" + this.calculatorValue);
        this.operator = null;
      }
    },
  },
  computed: {
    loginSuccess() {
      return this.loginStatus === "Validation success";
    },
  },
};
</script>

<style scoped>
.calc-body {
  background-color: #aaaaaa;
  width: 25%;
  margin: auto;
  padding: 10px;
}

.input {
  font-size: 30px;
  background-color: #f5f5f5;
  border: 1px solid;
  border-radius: 15px;
  width: 75%;
  margin: auto;
}

.grid-container {
  margin: auto;
  width: 260px;
}

.log {
  border: 2px #aaaaaa dashed;
  border-radius: 10px;
  padding: 10px;
  width: 30%;
  margin: 20px auto auto;
}

.log p {
  margin-top: 0px;
}

.btn {
  font-size: 28px;
  width: 50px;
  margin-left: 10px;
  margin-top: 10px;
  border: 2px solid black;
  color: #ff8c00;
  background-color: #2c3e50;
  transition-duration: 0.2s;
}

.btn:hover {
  transform: scale(1.05);
}

.event-btn {
  color: #ff0000;
}
</style>
