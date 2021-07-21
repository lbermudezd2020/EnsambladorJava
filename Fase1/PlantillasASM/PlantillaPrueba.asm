; multi-segment executable file template.

data segment
    ; add your data here!
    pkey db "press any key...$"
    var1 db 'hola'
    var2 dw 0
    
ends

stack segment
    dw   128  dup(0)
ends

code segment
start:
; set segment registers:
    mov ax, data
    mov ds, ax
    mov es, ax

    ; add your code here
            
    lea dx, pkey
    mov ah, 9
    int 21h        ; output string at ds:dx
    
    ; wait for any key....    
    mov ah, 1
    int 21h
    
    mov ah,[di]
    
    mov ax, 4c00h ; exit to operating system.
    int 21h    
ends
