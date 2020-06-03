<template>
  <div>
    <textarea v-model="secret" cols="100" />
    <div>
      <button @click="reset">Reset</button>
    </div>
  </div>
</template>

<script>
import CryptoJS from 'crypto-js'
import axios from 'axios'

export default {
  name: 'Decrypt',
  data: () => ({
    secret: null
  }),
  async created () {
    const requestId = this.$route.params.requestId
    const secretKey = this.$route.params.secretKey

    if (requestId && secretKey) {
      const cipherText = await axios
        .get('/api/cipher/read', {
          params: {
            requestId
          }
        })
        .then(response => response.data)

      if (cipherText) {
        var bytes = CryptoJS.AES.decrypt(cipherText, secretKey)
        console.log(bytes)
        this.secret = bytes.toString(CryptoJS.enc.Utf8)
      } else {
        this.secret = 'The requested secret is no longer available.'
      }
    }
  },
  methods: {
    reset () {
      this.$router.push({ name: 'Encrypt' })
    }
  }
}
</script>
