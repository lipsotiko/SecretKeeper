<template>
  <div>
    <div>
      <textarea
        v-model="secret"
        cols="100"
        placeholder="Input a secret you would like to share..."
      />
      <div>
        <button @click="encrypt">Create Shareable Link</button>
        <button @click="reset">Reset</button>
      </div>
    </div>
    <div v-if="decryptUrl" class="decrypt-url">
      <input
        v-model="decryptUrl"
        rows="3"
        cols="100"
        ref="decrypt-url"
      />
      <button @click="copy()">Copy</button>
    </div>
  </div>
</template>

<script>
import CryptoJS from 'crypto-js'
import { v4 as uuidv4 } from 'uuid'
import axios from 'axios'

export default {
  name: 'Encrypt',
  data: () => ({
    secret: null,
    decryptUrl: null
  }),
  methods: {
    async encrypt () {
      const secrtetKey = btoa(uuidv4())
      var cipherText = CryptoJS.AES.encrypt(this.secret, secrtetKey).toString()

      const requestGuid = await axios
        .post('/api/cipher/save', {
          cipherText
        })
        .then(response => response.data)

      this.decryptUrl =
        window.location.href + 'r/' + requestGuid + '/k/' + secrtetKey
    },
    copy () {
      this.$refs['decrypt-url'].select()
      document.execCommand('copy')
    },
    reset () {
      this.secret = null
      this.decryptUrl = null
    }
  }
}
</script>
<style scoped>
.decrypt-url {
  margin-top: 12px;
}

.decrypt-url input {
  width: 768px;
}
</style>
