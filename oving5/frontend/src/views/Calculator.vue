<template>
  <div class="heading">Calculator</div>
  <Calculator />
</template>

<script>
import Calculator from "../components/Calculator";

export default {
  name: "Calculator",
  components: {
    Calculator,
  },
};
</script>

<style>
.heading {
  font-size: 36px;
  font-weight: bold;
  margin-top: 100px;
}
</style>
