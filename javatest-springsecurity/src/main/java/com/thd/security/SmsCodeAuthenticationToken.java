package com.thd.security;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;

public class SmsCodeAuthenticationToken extends AbstractAuthenticationToken{
	 private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

	    //~ Instance fields ================================================================================================

	    private final Object mobile; //验证之前是手机号  验证之后是用户

	    //~ Constructors ===================================================================================================

	    /**
	     * This constructor can be safely used by any code that wishes to create a
	     * <code>UsernamePasswordAuthenticationToken</code>, as the {@link
	     * #isAuthenticated()} will return <code>false</code>.
	     *
	     */
	    public SmsCodeAuthenticationToken(Object mobile) {
	        super(null);
	        this.mobile = mobile;
	        setAuthenticated(false);
	    }

	    /**
	     * This constructor should only be used by <code>AuthenticationManager</code> or <code>AuthenticationProvider</code>
	     * implementations that are satisfied with producing a trusted (i.e. {@link #isAuthenticated()} = <code>true</code>)
	     * authentication token.
	     *
	     * @param principal
	     * @param credentials
	     * @param authorities
	     */
	    public SmsCodeAuthenticationToken(Object mobile,  Collection<? extends GrantedAuthority> authorities) {
	        super(authorities);
	        this.mobile = mobile;
	        super.setAuthenticated(true); // must use super, as we override
	    }


	    //~ Methods ========================================================================================================

	    public Object getCredentials() {
	        return null;
	    }

	    public Object getPrincipal() {
	        return this.mobile;
	    }

	    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
	        if (isAuthenticated) {
	            throw new IllegalArgumentException(
	                "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
	        }

	        super.setAuthenticated(false);
	    }

	    @Override
	    public void eraseCredentials() {
	        super.eraseCredentials();
	    }
}