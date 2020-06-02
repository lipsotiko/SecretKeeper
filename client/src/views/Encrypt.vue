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
    <dialog ref="dialog">
      <div v-if="!loading && shortDecryptUrl">
        <input v-model="shortDecryptUrl" ref="decrypt-url" />
        <button @click="copy">Copy</button>
        <button @click="reset">Close</button>
      </div>
      <span v-if="loading">loading...</span>
    </dialog>
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
    shortDecryptUrl: null,
    loading: false
  }),
  methods: {
    async encrypt () {
      this.$refs.dialog.showModal()
      this.loading = true

      const secrtetKey = btoa(uuidv4())
      var cipherText = CryptoJS.AES.encrypt(this.secret, secrtetKey).toString()
      this.secret = null

      const requestGuid = await axios
        .post('/api/cipher/save', {
          cipherText
        })
        .then(response => response.data)

      const longDecryptUrl =
        window.location.href + 'r/' + requestGuid + '/k/' + secrtetKey

      this.shortDecryptUrl = await axios('/api/url/shorten', {
        params: {
          longUrl: longDecryptUrl
        }
      }).then(response => response.data.link)

      this.loading = false
    },
    copy () {
      this.$refs['decrypt-url'].select()
      document.execCommand('copy')
    },
    reset () {
      this.secret = null
      this.shortDecryptUrl = null
      this.$refs.dialog.close()
    }
  }
}
</script>
<style>
input {
  width: 142px;
  margin-right: 12px;
}

dialog {
  top: 40vh;
  border-radius: 5px;
  border: 1px solid black;
  text-align: center;
}

dialog + .backdrop {
  background-color: rgba(0, 0, 0, 0.4);
}
</style>
