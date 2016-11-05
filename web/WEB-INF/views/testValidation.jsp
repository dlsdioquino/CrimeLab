<form action="" id="the-form">

    <input type="file" multiple="multiple" name="images"
           data-validation="length mime size"
           data-validation-length="min2"
           data-validation-allowing="jpg, png, gif"
           data-validation-error-msg="You have to upload at least two images (max 512kb each)"
           />
    <p>
        E-mail
        <input name="..." data-validation="email" data-validation-help="Som help info...">
    </p>
    <p>
        URL
        <input name="..." data-validation="url">
    </p>
    <p>
        Only allows alphanumeric characters and hyphen and underscore
        <input name="..." data-validation="alphanumeric" data-validation-allowing="-_">
    </p>
    <p>
        Only lowercase letters a-z (regexp)
        <input name="..." data-validation="custom" data-validation-regexp="^([a-z]+)$">
    </p>
    <p>
        Minimum 5 chars
        <input name="..." data-validation="length" data-validation-length="min5">
    </p>
    <p>
        Maximum 5 chars
        <input name="..." data-validation="length" data-validation-length="max5">
    </p>
    <p>
        Between 3-5 chars
        <input name="..." data-validation="length" data-validation-length="3-5">
    </p>
    <p>
        What's your favorite color?
        <input name="..." data-suggestions="White, Green, Blue, Black, Brown">
    </p>
    <p>
        Validate e-mail but only if an answer is given
        <input name="..." data-validation="email" data-validation-optional="true">
    </p>
    <p>
        Validate e-mail but only if checkbox is checked
        <input type="checkbox" name="checkit">
        <input name="..." data-validation="email" data-validation-if-checked="checkit">
    </p>
    <p>
        Restrict length
        <span id="max-length-element">100</span> chars left
        <textarea id="the-textarea" name="text"></textarea>
    </p>
    <p>
        <input type="submit">
    </p>
</form>
<script>
    $.validate({
        validateOnBlur: false, // disable validation when input looses focus
        errorMessagePosition: 'top', // Instead of 'element' which is default
        scrollToTopOnError : false // Set this property to true if you have a long form
    });
    $('#my-textarea').restrictLength($('#max-length-element'));
</script>