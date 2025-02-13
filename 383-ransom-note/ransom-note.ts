function canConstruct(ransomNote: string, magazine: string): boolean {
    let canConstruct = true;
    const ransomNoteMap = new Map();
    const magazineMap = new Map();
    for(let i = 0; i < ransomNote.length; i ++){
        if(!ransomNoteMap.get(ransomNote.charAt(i))){
            ransomNoteMap.set(ransomNote.charAt(i),1);
        }
        else
        ransomNoteMap.set(ransomNote.charAt(i),ransomNoteMap.get(ransomNote.charAt(i)) + 1);
    }
    for(let i = 0; i < magazine.length; i ++){
        if(!magazineMap.get(magazine.charAt(i))){
            magazineMap.set(magazine.charAt(i),1);
        }
        else
        magazineMap.set(magazine.charAt(i),magazineMap.get(magazine.charAt(i)) + 1);
    }
    ransomNoteMap.forEach((value,key)=>{
        if((magazineMap.get(key) == undefined ) || (magazineMap.get(key) < value)) canConstruct = false;
    })
    return canConstruct;
};