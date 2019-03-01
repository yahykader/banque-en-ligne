package org.greta.security;


/**
 * Copyright (c) 2008-2011 Sonatype, Inc.
 * All rights reserved. Includes the third-party code listed at http://www.sonatype.com/products/nexus/attributions.
 *
 * This program is free software: you can redistribute it and/or modify it only under the terms of the GNU Affero General
 * Public License Version 3 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License Version 3
 * for more details.
 *
 * You should have received a copy of the GNU Affero General Public License Version 3 along with this program.  If not, see
 * http://www.gnu.org/licenses.
 *
 * Sonatype Nexus (TM) Open Source Version is available from Sonatype, Inc. Sonatype and Sonatype Nexus are trademarks of
 * Sonatype, Inc. Apache Maven is a trademark of the Apache Foundation. M2Eclipse is a trademark of the Eclipse Foundation.
 * All other trademarks are the property of their respective owners.
 */


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

import org.springframework.security.crypto.codec.Hex;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author cstamas
 */
@Component
public abstract class MD5PasswordEncoder implements PasswordEncoder
{

    public  String getMethod()
    {
        return "MD5";
    }

    public  String encodePassword( String password, Object salt )
    {
        return "{MD5}" + encodeString( password );
    }

    public  boolean isPasswordValid( String encPassword, String inputPassword, Object salt )
    {
        String encryptedPassword = this.stripHeader( encPassword );
        String check = this.stripHeader( encodePassword( inputPassword, salt ) );

        return check.equals( encryptedPassword );
    }
    
    protected  String stripHeader( String encryptedPassword )
    {
        if ( encryptedPassword.startsWith( "{" + getMethod().toUpperCase() + "}" )
            || encryptedPassword.startsWith( "{" + getMethod().toLowerCase() + "}" ) )
        {
            encryptedPassword = encryptedPassword.substring( "{MD5}".length() );
        }
        return encryptedPassword;
    }


    protected  String encodeString( String input )
    {
        InputStream is = new ByteArrayInputStream( input.getBytes() );
        String result = null;
        try
        {
            byte[] buffer = new byte[1024];
            MessageDigest md5 = MessageDigest.getInstance( "MD5" );
            int numRead;
            do
            {
                numRead = is.read( buffer );
                if ( numRead > 0 )
                {
                    md5.update( buffer, 0, numRead );
                }
            }
            while ( numRead != -1 );
            result = new String( Hex.encode( md5.digest() ) );
        }
        catch ( Exception e )
        {
        }
        return result;
    }

	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		// TODO Auto-generated method stub
		return false;
	}

}
