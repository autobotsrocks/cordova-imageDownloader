# cordova-ImageDownloader
A cordova plugin that provides the functionality to download internet image file to android photos gallery.

# Installing the plugin

```shell
cordova plugin add https://github.com/autobotsrocks/cordova-ImageDownloader
```

# Usage

```javascript
window.autobots.imageDownloader.download(
  'https://www.google.com/images/srpr/logo11w.png',
  function() {
    alert('success');
  },
  function() {
    alert('failed');
  }
);
```

# License

MIT