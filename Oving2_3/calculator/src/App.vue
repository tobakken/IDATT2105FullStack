<template>
  <div id="app">
    <div id="nav">
      <router-link :to="{ name: 'Home' }">Calculator</router-link> |
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
  color: #2c3e50;
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

.field {
  margin-bottom: 24px;
}

input,
text{
  display: inline-flex;
  font-family: "Open sans", sans-serif;
  font-size: 100%;
  line-height: 1.15;
  margin: 10px;
}
.error {
  border: 1px solid red;
}
.errorMessage {
  color:red;
}

</style>
