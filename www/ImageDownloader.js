var ImageDownloader = function() {
};

ImageDownloader.prototype.download = function(url, success, fail) {
  var parts = url.split('/'),
      fileTransfer = new FileTransfer();

  fileTransfer.download(
    url,
    cordova.file.externalRootDirectory + '/Pictures/' + parts[parts.length - 1],
    function(entry) {
      var imagePath = entry.toURL().replace(/^file:\/\//i, '');
      return cordova.exec(success, fail, 'CopyToGallery', 'copy', [imagePath]);
    },
    fail
  );
};

module.exports = new ImageDownloader();