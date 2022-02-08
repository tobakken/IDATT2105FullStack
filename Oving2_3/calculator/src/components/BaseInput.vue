<template>
  <label
      v-if="label"
  >
    {{ label }}
  </label>
  <input
      v-bind="$attrs"
      :value="modelValue"
      @input="$emit('update:modelValue', $event.target.value)"
      class="field"
      :placeholder="label"
      :class="{error}"
  >
  <BaseErrorMessage
      v-if="error"
  >
    {{ error }}
  </BaseErrorMessage>
</template>

<script>
import BaseErrorMessage from "./BaseErrorMessage";

export default {
  props: {
    label: {
      type: String,
      default: ''
    },
    modelValue: {
      type: [String, Number],
      default: ''
    },
    error: {
      type: String,
      default: ''
    }
  },
  components: BaseErrorMessage
}
</script>
