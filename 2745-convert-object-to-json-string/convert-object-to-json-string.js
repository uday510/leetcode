var jsonStringify = function(object) {
    if (object == null) {
        return 'null';
    }

    if (Array.isArray(object)) {
        const nums = object.map(num => jsonStringify(num));

        return `[${nums.join(',')}]`;
    }

    if (typeof object == 'object') {
        const keys = Object.keys(object);
        const pairs = keys.map(key => `"${key}":${jsonStringify(object[key])}`);

        return `{${pairs.join(",")}}`;
    }

    if (typeof object === 'string') {
        return `"${object}"`
    }

    return String(object);

};