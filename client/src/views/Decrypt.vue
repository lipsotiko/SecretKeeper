<template>
  <div class="container">
    <textarea v-model="secret" />
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
    const fileName = this.$route.params.fileName

    if (requestId && secretKey) {
      const cipher = await axios
        .get('/api/cipher/read', {
          params: {
            requestId
          }
        })
        .then(response => response.data)

      if (cipher) {
        var bytes = CryptoJS.AES.decrypt(cipher.cipher, secretKey)
        var str = bytes.toString(CryptoJS.enc.Utf8)
        if (fileName === 'text') {
          this.secret = str
        } else {
          var ab = new ArrayBuffer(str.length)
          var ia = new Uint8Array(ab)
          for (var i = 0; i < str.length; i++) {
            ia[i] = str.charCodeAt(i)
          }
          const linkhref = window.URL.createObjectURL(new Blob([ab]))
          const link = document.createElement('a')
          link.href = linkhref
          link.setAttribute('download', fileName)
          document.body.appendChild(link)
          link.click()
        }
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
