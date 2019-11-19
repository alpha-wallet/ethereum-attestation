/**
 * This file was generated by the Objective Systems ASN1C Compiler
 * (http://www.obj-sys.com).  Version: 7.3.4, Date: 19-Nov-2019.
 */
package id.attestation;

import com.objsys.asn1j.runtime.*;

public class RelativeDistinguishedName extends Asn1SetOf {
   private static final long serialVersionUID = 55;
   static {
      _setKey (_TICKET_ATTESTATIONRtkey._rtkey);
      Asn1Type._setLicLocation(_TICKET_ATTESTATIONRtkey._licLocation);
   }

   public String getAsn1TypeName()  {
      return "RelativeDistinguishedName";
   }

   public AttributeTypeAndValue[] elements;

   public RelativeDistinguishedName () {
      elements = null;
   }

   /**
    * This constructor initializes the internal array to hold the 
    * given number of elements.  The element values must be manually 
    * populated.
    */
   public RelativeDistinguishedName (int numRecords) {
      elements = new AttributeTypeAndValue [numRecords];
   }

   /**
    * This constructor initializes the internal array to hold the 
    * given the array.  
    */
   public RelativeDistinguishedName (AttributeTypeAndValue[] elements_) {
      elements = elements_;
   }

   public Asn1Type[] getElementValues() { return elements; }


   public void decode
      (Asn1BerDecodeBuffer buffer, boolean explicit, int implicitLength)
      throws Asn1Exception, java.io.IOException
   {
      int llen = (explicit) ?
         matchTag (buffer, Asn1Tag.SET) : implicitLength;

      // decode SEQUENCE OF or SET OF

      java.util.LinkedList<AttributeTypeAndValue> llist =
         new java.util.LinkedList<AttributeTypeAndValue>();
      Asn1BerDecodeContext _context =
          new Asn1BerDecodeContext (buffer, llen);
      AttributeTypeAndValue element;
      int elemLen = 0;
      int i = 0;

      while (!_context.expired()) {
         buffer.getContext().eventDispatcher.startElement("elements", i++);

         element = new AttributeTypeAndValue();
         element.decode (buffer, true, elemLen);

         buffer.getContext().eventDispatcher.endElement("elements", i);
         llist.add (element);
      }

      elements = new AttributeTypeAndValue [llist.size()];
      llist.toArray (elements);

      if (!(elements.length >= 1)) {
         throw new Asn1ConsVioException ("elements.length", elements.length);
      }

      if (explicit && llen == Asn1Status.INDEFLEN) {
         matchTag (buffer, Asn1Tag.EOC);
      }
   }

   public int encode (Asn1BerEncodeBuffer buffer, boolean explicit)
      throws Asn1Exception
   {
      int _aal = 0, len;

      // encode SEQUENCE OF or SET OF

      if (!(elements.length >= 1)) {
         throw new Asn1ConsVioException ("elements.length", elements.length);
      }

      for (int i = elements.length - 1; i >= 0; i--) {
         buffer.getContext().eventDispatcher.startElement("elements[" + i + "]", -1);

         len = elements[i].encode (buffer, true);
         _aal += len;

         buffer.getContext().eventDispatcher.endElement("elements[" + i + "]", -1);
      }

      if (explicit) {
         _aal += buffer.encodeTagAndLength (Asn1Tag.SET, _aal);
      }

      return (_aal);
   }

   public void decode( Asn1JsonDecodeBuffer buffer ) throws java.io.IOException
   {
      java.util.LinkedList<AttributeTypeAndValue> temp_seqof_list = new java.util.LinkedList<AttributeTypeAndValue>();
      /* decode as JSON array */
      buffer.readCharacter('[');
      if ( buffer.nextCharacterIsNot(']') ) {
         for(;;)  {
            AttributeTypeAndValue current_element_instance = new AttributeTypeAndValue();
            current_element_instance.decode(buffer);
            temp_seqof_list.add(current_element_instance);

            if (buffer.nextCharacterIs(',')) {
               buffer.readCharacter(',');
               // loop around for next element
            }
            else break; //no more elems to decode

         }
      }
      buffer.readCharacter(']');

      elements = new AttributeTypeAndValue[temp_seqof_list.size()];
      temp_seqof_list.toArray (elements);
      if (!(elements.length >= 1)) {
         throw new Asn1ConsVioException ("elements.length", elements.length);
      }

   }


   public void encode( Asn1JsonOutputStream outstream ) throws java.io.IOException
   {
      if (!(elements.length >= 1)) {
         throw new Asn1ConsVioException ("elements.length", elements.length);
      }

      /* encode SEQUENCE OF or SET OF */

      outstream.write('[');
      outstream.incrLevel();
      outstream.indent();
      for (int i = 0; i < this.elements.length; i++) {
         if ( i > 0 ) {
            outstream.write(',');
            outstream.indent();
         }
         this.elements[i].encode(outstream);
      }
      outstream.decrLevel();
      outstream.indent();
      outstream.write(']');
   }


}
