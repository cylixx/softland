package com.softland.example.persistence.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

public class GenericSpecifications<T> {
//	T obj;
//
//	public GenericSpecifications(T o) {
//		super();
//		obj = o;
//	}
	
	public Specification<T> filterQuery(Map<String, String> mapFilter) { 
        return (root, query, cb) -> {
            // Create query here
            Predicate where = cb.conjunction();
            String key = null;
            String value = null;
            
            for (final Entry<String, String> intem : mapFilter.entrySet()) {
                key = intem.getKey();
                value = intem.getValue();

                if ((key != null) && (value != null)) {
                    
                    Path fieldPath = root.get(key);
                    if ( key.equals("startOperation") || key.equals("modifOperation") ) {
                        fieldPath = root.<Date>get(key);
                    }
                    

                    if (value.contains("%")) {  //LIKE
                        //where = cb.and(where, cb.like(root.get(key), value));
                        where = cb.and(where, cb.like(fieldPath, value));
                        
                    } else if (value.contains("|")) {   //IN
                        StringTokenizer st = new StringTokenizer(value, "|");
                        List<String> valueList = new ArrayList<String>();
                        while (st.hasMoreElements()) {
                            valueList.add( st.nextElement().toString().trim() );
                        }
                        
                        Expression<String> exp = root.get( key );
                        where = cb.and(where, exp.in( valueList ));
                        
                    } else {  
                        //where = cb.and(where, cb.equal(root.get(key), value));
                        where = cb.and(where, cb.equal(fieldPath, value));
                    }
                }
            }
            return where;
        };
    }
	
}
