<template>
  <label v-if="label">
    {{ label }}
  </label>
  <input
    v-bind="$attrs"
    :value="modelValue"
    @input="$emit('update:modelValue', $event.target.value)"
    class="field"
    :placeholder="label"
    :aria-invalid="error ? true : false"
    :class="{ error }"
  />
  <p class="errorMessage" v-if="error">
    {{ error }}
  </p>
</template>

<script>
export default {
  props: {
    label: {
      type: String,
      default: "",
    },
    modelValue: {
      type: [String, Number],
      default: "",
    },
    error: {
      type: String,
      default: "",
    },
  },
};
</script>
