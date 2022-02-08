<template>
  <div id="nav">
    <router-link :to="{name: 'Calculator'}">Calculator</router-link>
    <router-link :to="{name: 'Contact'}">Contact</router-link>
  </div>
</template>

<script>
export default {
  name: "NavBar"
}
</script>

<style scoped>
#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}

</style>