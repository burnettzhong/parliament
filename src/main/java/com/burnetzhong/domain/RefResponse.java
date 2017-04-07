package com.burnetzhong.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.burnetzhong.domain.refs.GenericRef;
import com.burnetzhong.domain.refs.RefFormat;
import com.burnetzhong.domain.refs.RefType;

/**
 * Created by Helmsdown on 7/8/15.
 *
 * This class extends directly from Response for now. At some future date we will need
 * to make {@link com.burnetzhong.domain.Response} an interface to follow the pattern established by
 * {@link com.burnetzhong.domain.Model}, {@link com.burnetzhong.domain.properties.Object} and {@link com.burnetzhong.domain.parameters.Parameter}
 */
public class RefResponse extends Response {

    private GenericRef genericRef;

    public RefResponse() {
    }

    public RefResponse(String ref) {
        set$ref(ref);
    }

    public void set$ref(String ref) {
        this.genericRef = new GenericRef(RefType.RESPONSE, ref);
    }

    public String get$ref() {
        return genericRef.getRef();
    }

    @JsonIgnore
    public String getSimpleRef() {
        return genericRef.getSimpleRef();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RefResponse refResponse = (RefResponse) o;

        return !(genericRef != null ? !genericRef.equals(refResponse.genericRef) : refResponse.genericRef != null);

    }

    @Override
    public int hashCode() {
        return genericRef != null ? genericRef.hashCode() : 0;
    }

    @JsonIgnore
    public RefFormat getRefFormat() {
        return this.genericRef.getFormat();
    }

}
