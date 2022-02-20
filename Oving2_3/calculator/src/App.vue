<template>
  <div id="app">
    <div id="nav">
      <router-link :to="{ name: 'Calculator' }">Calculator</router-link> |
      <router-link :to="{ name: 'Contact' }">Contact</router-link>
    </div>
  </div>
  <router-view />
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
}

#nav {
  margin: auto;
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
form {
  width: 100px;
  margin: auto;
  padding: 50px 0 ;
}


</style>
