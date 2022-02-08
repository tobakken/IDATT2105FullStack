<template>
  <div class="heading">Calculator</div>
    <Calculator />
</template>

<script>
// @ is an alias to /src
import Calculator from "../components/Calculator";

export default {
  name: "Home",
  components: {
    Calculator
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
